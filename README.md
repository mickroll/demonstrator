# demonstrator

surefire 3.0.0-M6 excludes a test from the test result, if an exception with a long message (~1000) is thrown from an inner class.

run:
```
    $ mvn test
    [...]
    [INFO] Running org.example.ThrowExceptionWithLongMessageTest
    [INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.044 s - in org.example.ThrowExceptionWithLongMessageTest
    [INFO]
    [INFO] Results:
    [INFO]
    [INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
    [INFO]
    [WARNING] Corrupted channel by directly writing to native stream in forked JVM 1. See FAQ web page and the dump file     [INFO]     [...]
    [...]
    [INFO] BUILD SUCCESS
```

Using `mvn test -X`, one can see the thrown exception:
```
    [INFO] Running org.example.ThrowExceptionWithLongMessageTest
    [DEBUG] AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA:  !?:java.lang.IllegalStateException: AAAA[...]AAAAAAAA
    [DEBUG]         at org.example.ThrowExceptionWithLongMessageTest$Inner.throwException(ThrowExceptionWithLongMessageTest.java:18)
    [DEBUG]         at org.example.ThrowExceptionWithLongMessageTest.example(ThrowExceptionWithLongMessageTest.java:9)
```

surefire 3.0.0-M5 fails the test like expected:
```
    [INFO] Running org.example.ThrowExceptionWithLongMessageTest
    [ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.036 s <<< FAILURE! - in org.example.ThrowExceptionWithLongMessageTest
```
