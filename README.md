# Playing GraalVM with R and Python

## Get into the container and play from shell
Main binaries when entering the container:
- java / javac (Java 8)
- graalpython (python 3.7)
- R (R 3.6)

```
docker run -it --rm -w /code -v $(pwd)/code:/code graalvmpyr:latest bash
```

## Java examples
Define a basic alias to launch commands `alias gr='docker run -it --rm -w /code -v $(pwd)/code:/code graalvmpyr:latest sh -c'`

Run the Java HelloWorld
```
CLASSNAME=HelloWorld; gr "javac $CLASSNAME.java && java $CLASSNAME"
```

Run the Polyglot example
```
CLASSNAME=PolyglotArray; gr "javac $CLASSNAME.java && java $CLASSNAME"
```
