# graalvmpyr
Playing GraalVM with R and Python

Main binaries when entering the container:
- java / javac (Java 8)
- graalpython (python 3.7)
- R (R 3.6)

Enter VM
```
docker run -it --rm -w /code -v $(pwd)/code:/code graalvmpyr:latest bash
```

Run the HelloWorld
```
alias gr='docker run -it --rm -w /code -v $(pwd)/code:/code graalvmpyr:latest sh -c'
gr "javac *.java"
gr "java HelloWorld"
```
