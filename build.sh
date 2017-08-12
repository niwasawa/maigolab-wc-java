bazel clean
bazel build maigolab-wc
mv -f bazel-bin/libmaigolab-wc.jar dist/maigolab-wc.jar
bazel clean

