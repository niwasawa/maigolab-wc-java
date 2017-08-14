java_library(
  name = "maigolab-wc",
  srcs = glob(["src/main/java/**/*.java"]),
  javacopts = [
    "-source 1.7",
    "-target 1.7",
  ],
)

java_test(
  name = "all",
  size = "small",
  deps = [
    ":maigolab-wc",
    "@junit//jar",
  ],
  srcs = glob(["src/test/java/**/*.java"]),
  test_class = "AllTests",
)

