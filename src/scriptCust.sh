#!/bin/bash

echo "Execute Program 10 Times Every SetPartitioning"

for i in {1..10} 
	do  
		echo "--------------- Execution Time: $i --------------------"		
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/delta.txt 1 ../heuristic-cust/delta.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/heart.txt 1 ../heuristic-cust/heart.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/meteor.txt 1 ../heuristic-cust/meteor.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppaa06.txt 1 ../heuristic-cust/sppaa06.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw32.txt 1 ../heuristic-cust/sppnw32.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw34.txt 1 ../heuristic-cust/sppnw34.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw36.txt 1 ../heuristic-cust/sppnw36.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw41.txt 1 ../heuristic-cust/sppnw41.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw05.txt 1 ../heuristic-cust/sppnw05.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw16.txt 1 ../heuristic-cust/sppnw16.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppus01.txt 1 ../heuristic-cust/sppus01.txt 100 0.05 50 1800
	done
