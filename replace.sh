#!/bin/sh
# Sample shell script to read and act on properties 
# source the properties:
#!/usr/bin/env bash

# Usage: $0 [input file] [translation file] [output file]

mapfile -t < "$2"
declare -A replacements
for keyvalue in "${MAPFILE[@]}"
do
  if [[ $keyvalue =~ (.+)=(.+) ]]
  then
     k="${BASH_REMATCH[1]}"
     v="${BASH_REMATCH[2]}"
     replacements[$k]="$v"
  fi
done

mapfile -t < "$1"
for line in "${MAPFILE[@]}"
do
  for pattern in "${!replacements[@]}"
  do
    line="${line//\[\[$pattern\]\]/${replacements[$pattern]}}"
  done
  printf "%s\n" "$line"
done > "$3"