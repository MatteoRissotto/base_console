/*
 This file is auto-generated by the statrep package.
 Do not edit this file or your changes will be lost.
 Edit the LaTeX file instead.
 
 See the statrep package documentation and the file
 statrep.cfg for information on these settings.
 */
 
 
/* Set and invoke macro variable defaults. */
%let rootdir=.;
%let defaultstyle=statistical;
%let latexstyle=statrep;
%let graphtype=png;
%let graphicdir=./png;
%let listingdir=./lst;
%let latexdir=./tex;
%let defaultlinesize=80;
%let defaultpagesize=500;
%let defaultdpi=300;
%let odsgraphopts=;
%let defaultdests=listing;

options nodate nonumber
ls=&defaultlinesize ps=&defaultpagesize
formchar='|----|+|---+=|-/\<>*';

ods graphics on;
/* Include SAS macro definitions. */
%include "statrep_macros.sas" /nosource;

