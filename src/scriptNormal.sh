#!/bin/bash

echo "Execute Program 10 Times Every SetPartitioning"

for i in {1..10} 
	do  
		echo "--------------- Execution Time: $i --------------------"		
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/delta.txt 0 ../heuristic-normal/delta.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/heart.txt 0 ../heuristic-normal/heart.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/meteor.txt 0 ../heuristic-normal/meteor.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppaa06.txt 0 ../heuristic-normal/sppaa06.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw32.txt 0 ../heuristic-normal/sppnw32.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw34.txt 0 ../heuristic-normal/sppnw34.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw36.txt 0 ../heuristic-normal/sppnw36.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw41.txt 0 ../heuristic-normal/sppnw41.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw05.txt 0 ../heuristic-normal/sppnw05.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw16.txt 0 ../heuristic-normal/sppnw16.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppus01.txt 0 ../heuristic-normal/sppus01.txt 100 0.05 50 1800
	done
