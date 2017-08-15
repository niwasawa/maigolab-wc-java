bazel clean
bazel build maigolab-wc
mkdir dist
mv -f bazel-bin/libmaigolab-wc.jar dist/maigolab-wc.jar
bazel clean

