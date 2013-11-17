# Makefile para compilar e executar os códigos
# Pasta set-partitioning deve ser colocada dentro da home


ClassPathLib=class:lib/guava-15.0.jar

compile:
	javac -d class -cp lib/guava-15.0.jar *.java

execute:
	java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw32.txt

creat-datafiles:
	java -cp class -XX:MaxHeapSize=2048m -Xmx1024m MathProgDatConversor ../instancias ../glpk/dat

clean:
	rm class/*.class
