#!/usr/bin/perl

use strict;
use warnings;
use 5.12.3;

##	---

opendir( my $dh, '../src/org/usfirst/frc/team5534/robot/');
my @files = sort grep { /.java$/ } readdir $dh;
close $dh;


my $tex = join '', map {
	'\newpage\section*{'.$_.'}\filelister{'.$_.'}'."\n"
} @files;

open my $fh, '>encoding(UTF-8)', './include/robot-code.tex';
print $fh $tex;
close $fh;

`pdflatex Onabots-5534.tex`;
