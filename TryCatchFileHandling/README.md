# TryCatchFileHandling

A small Java example that reads text from a file and appends it to another file, using `try-catch` blocks to handle file I/O errors.

## Files

- `TryCatchFileHandler.java` — reads `testText.txt`, prints its contents, and appends them to `outputCOPY.txt`.
- `testText.txt` — the source text file.
- `outputCOPY.txt` — the destination file. Existing content is preserved; each run appends another copy.

## Run

Open a terminal in this directory, then compile and run:

```bash
javac TryCatchFileHandler.java
java TryCatchFileHandler
```

The program expects both text files to be in the current working directory. To change the input text, edit `testText.txt`. The reader is currently called with `true`, so it also prints the source contents to the console.

If reading or writing fails, the program prints an error message describing the I/O problem.
