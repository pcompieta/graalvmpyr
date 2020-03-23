# Playing GraalVM with R and Python

More examples at https://github.com/graalvm/graalvm-demos and https://github.com/chrisseaton/graalvm-ten-things 

## Get into the container and play from shell
Main binaries when entering the container:
- java / javac (Java 8)
- graalpython (python 3.7)
- R (R 3.6)

```
docker run -it --rm -w /code -v $(pwd)/simple-code:/code graalvmpyr:latest bash
```

## Simple code examples
Define a basic alias to launch commands `alias gr='docker run -it --rm -w /code -v $(pwd)/simple-code:/code graalvmpyr:latest sh -c'`

Run the Java HelloWorld
```
CLASSNAME=HelloWorld; gr "javac $CLASSNAME.java && java $CLASSNAME"
```

Run the Polyglot example
```
CLASSNAME=PolyglotArray; gr "javac $CLASSNAME.java && java $CLASSNAME"
```

## Logistic regression example
```
gr "javac com/pcompieta/graalvm/App.java"; gr "java com.pcompieta.graalvm.App"
```