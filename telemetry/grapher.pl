#!/usr/bin/perl

use strict;
use warnings;
use 5.12.3;

## ---

##	Purpose of grapher.pl is to filter and format telemetry data from the Onabots
##	robot to display in gnuplot. The input file is called onabot-telemetry-data.txt
##	
##	DRIVETRAIN
##	- PowerL
##	- PowerR
##	  PowerD (calculated)
##	  PowerT (calculated)
##	
##	NAVIGATION
##	- Heading
##	- Distance
##	- Drive Speed
##	- Turn Speed
##	- Front Range
##	
##	STAGE
##	- Stage Number
##	- Stage Distance
##
##	VISION
##	- TargetScore
##	- Target X
##	- Target Y
##
##	NOTE
##	Generic tag has the form of Key:value;
##
##	TODO
##	[ ] Reduce tags to shorter 2 or 3 letter codes to reduce file size.
## [ ] Make the Telemetry class output tags in the beginning

##	OPEN SRC DATA FILE
open my $src, '<:encoding(UTF-8)', 'onabots-telemetry-data.txt';
open my $dst, '>:encoding(UTF-8)', 'gnuplot-telemetry-data.txt';

##	GNUPLOT METADATA
say $dst q|set term wxt|;
say $dst q|plot|;
say $dst q|'gnuplot-telemetry-data.txt' using 1:2 with lines,|;
say $dst q| title "Telemetry Data"|;
sat '';

while ( my $iline = <$src> ) {

	##	SPLIT
	my %hash = split /[:;]/, $iline;

	##	FORMAT

	##	OUTPUT
	say $dst, $oline;

}

##	CLOSE FILEHANDLES
close $src;
close $dst;



##	EXAMPLES
##	