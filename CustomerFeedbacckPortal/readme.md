# Customer Feedback Portal

A simple Java console application for collecting, viewing, searching, and saving customer feedback.

## Features

- Add new feedback with a customer's name, rating, and comment
- Display all saved feedback entries
- Calculate the average rating
- Search feedback by rating value
- Delete feedback entries by index
- Load existing feedback from `feedback.txt`
- Save feedback back to the file

## Project files

- `FeedbackPortal.java` — main program logic
- `feedback.txt` — stored feedback data

## How to run

From the directory containing the Java file, compile and run the app:

```bash
javac FeedbackPortal.java
java FeedbackPortal
```

## Menu options

1. Add feedback
2. Show all feedback
3. Show average rating
4. Search by rating
5. Delete feedback
6. Load feedback
7. Save to file
8. Save and exit

## Notes

- Ratings are limited to the range `1` to `5`.
- Feedback is saved in a simple text format using the `|` separator.
- The program reads and writes to `feedback.txt` in the current working directory.
