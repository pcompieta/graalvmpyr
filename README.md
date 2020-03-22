# graalvmpyr
Playing GraalVM with R and Python

Enter VM
`docker run -it -v $(pwd)/code:/code graalvmpyr:latest`

Run the HelloWorld
`docker run -it -v $(pwd)/code:/code graalvmpyr:latest "javac code/*.java; cd code && java HelloWorld"`