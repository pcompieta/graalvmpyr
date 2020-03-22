# run the container and do nice things

echo "javac code/*.java"
echo "cd code && java HelloWorld"

docker run -it -v $(pwd)/code:/code graalvmpyr:latest "javac code/*.java; cd code && java HelloWorld"