# Java Hangman Game

A simple command-line implementation of the classic Hangman word guessing game in Java.

## Description

This is a text-based Hangman game where players try to guess a word one letter at a time. The game features:
- Random word selection from a predefined word list
- Interactive command-line interface
- Score tracking for missed guesses
- Option to play multiple rounds

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Any Java IDE (Eclipse, IntelliJ, VS Code)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/msjackiebrown/java-hangman.git
```

2. Navigate to the project directory:
```bash
cd java-hangman/Hangman
```

3. Compile the Java file:
```bash
javac Hangman.java
```

4. Run the game:
```bash
java Hangman
```

## How to Play

1. The game will select a random word
2. Guess one letter at a time
3. If your guess is correct, the letter will be revealed in the word
4. If your guess is wrong, you'll accumulate a miss
5. Continue guessing until you either:
   - Successfully reveal the entire word
   - Or make too many wrong guesses
6. Choose to play again or exit

## Version History

* 1.0.2
    * Added support for multiple words and lists (9/14/2016)
    * Added support for more words (9/11/2016)

## Project Structure

```
Hangman/
├── Hangman.java    # Main game implementation
├── readme.md       # Version history
└── wordlists/      # Directory containing word lists
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Submit a pull request

## License

This project is available under the MIT License.

## Contact

* Repository owner: Jackie Brown
* Project Link: https://github.com/msjackiebrown/java-hangman

