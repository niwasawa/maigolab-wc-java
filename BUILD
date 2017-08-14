java_library(
  name = "maigolab-wc",
  srcs = glob(["src/main/java/**/*.java"]),
  javacopts = [
    "-source 1.7",
    "-target 1.7",
  ],
)

java_test(
  name = "ContentTypeTest",
  deps = [
    ":maigolab-wc",
    "@junit//jar",
  ],
  srcs = glob(["src/test/java/**/*.java"]),
  test_class = "info.maigo.lab.wc.ContentTypeTest",
)

java_test(
  name = "GetRequestTest",
  deps = [
    ":maigolab-wc",
    "@junit//jar",
  ],
  srcs = glob(["src/test/java/**/*.java"]),
  test_class = "info.maigo.lab.wc.GetRequestTest",
)

java_test(
  name = "AllTests",
  size = "small",
  deps = [
    ":maigolab-wc",
    "@junit//jar",
  ],
  srcs = glob(["src/test/java/**/*.java"]),
  test_class = "AllTests",
)

