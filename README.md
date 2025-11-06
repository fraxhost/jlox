# Lox Interpreter (Java)

An implementation of the **Lox** language from the book *Crafting Interpreters* by Robert Nystrom.
This project includes a full tree-walking interpreter, AST generator, and support for classes, inheritance, recursion, etc.

---

## 📁 Project Structure

```
root_directory/
│
├── src/
│   ├── Lox.java          # Entry point for the interpreter
│   ├── ...               # Scanner, Parser, Resolver, Interpreter, etc.
│
├── tool/
│   ├── AST.java          # AST generator tool
│
├── tests/             # Optional .lox programs
│
└── README.md
```

---

## ▶️ Running the Interpreter

### 1. Compile

```sh
cd root_directory
javac src/Lox.java
```

### 2. Run Interactively (REPL)

```sh
java src/Lox
```

### 3. Run a `.lox` Source File

```sh
java src/Lox path/to/file.lox
```

---

## 🛠️ Running the AST Generator

```sh
javac tool/AST.java
java tool/AST .
```

The final `.` means “generate classes in the current directory”.

---

## 📜 Grammar Specification

```
program        → declaration* EOF ;
declaration    → classDecl
               | funDecl
               | varDecl
               | statement ;
classDecl      → "class" IDENTIFIER ( "<" IDENTIFIER )?
                 "{" function* "}" ;
funDecl        → "fun" function ;
varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;
statement      → exprStmt
               | forStmt
               | ifStmt
               | printStmt
               | returnStmt
               | whileStmt
               | block ;
exprStmt       → expression ";" ;
forStmt        → "for" "(" ( varDecl | exprStmt | ";" )
                           expression? ";"
                           expression? ")" statement ;
ifStmt         → "if" "(" expression ")" statement
                 ( "else" statement )? ;
printStmt      → "print" expression ";" ;
returnStmt     → "return" expression? ";" ;
whileStmt      → "while" "(" expression ")" statement ;
block          → "{" declaration* "}" ;
expression     → assignment ;
assignment     → ( call "." )? IDENTIFIER "=" assignment
               | logic_or ;
logic_or       → logic_and ( "or" logic_and )* ;
logic_and      → equality ( "and" equality )* ;
equality       → comparison ( ( "!=" | "==" ) comparison )* ;
comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;
term           → factor ( ( "-" | "+" ) factor )* ;
factor         → unary ( ( "/" | "*" ) unary )* ;
unary          → ( "!" | "-" ) unary | call ;
call           → primary ( "(" arguments? ")" | "." IDENTIFIER )* ;
primary        → "true" | "false" | "nil" | "this"
               | NUMBER | STRING | IDENTIFIER | "(" expression ")"
               | "super" "." IDENTIFIER ;
function       → IDENTIFIER "(" parameters? ")" block ;
parameters     → IDENTIFIER ( "," IDENTIFIER )* ;
arguments      → expression ( "," expression )* ;
NUMBER         → DIGIT+ ( "." DIGIT+ )? ;
STRING         → "\"" <any char except "\"">* "\"" ;
IDENTIFIER     → ALPHA ( ALPHA | DIGIT )* ;
ALPHA          → "a" ... "z" | "A" ... "Z" | "_" ;
DIGIT          → "0" ... "9" ;
```

---

## ✅ Supported Features

* Arithmetic, boolean logic, grouping
* Variables + lexical scoping
* `if`, `while`, `for`, `return`
* Functions, closures, recursion
* Classes, fields, `this`
* Inheritance + `super`
* Logical operators (`and`, `or`)
* REPL and source-file execution

---

## 📚 Reference

Book: [https://craftinginterpreters.com](https://craftinginterpreters.com)
Language: Lox (tree-walking interpreter, Chapters 1-13)

---

## 📌 License

MIT (or include your own)

---

If you want me to:

✅ add example `.lox` programs
✅ add build & test section (Scala tests / JUnit / MUnit)
✅ add GitHub badges (build, license, etc.)

Just tell me: **"add examples"**, **"add CI section"**, etc.
