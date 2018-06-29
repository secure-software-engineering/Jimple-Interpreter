# Jimple-Interpreter
A Jimple interpreter

## Setup

1. Clone repo with `git clone --recurse-submodules https://github.com/secure-software-engineering/Jimple-Interpreter.git`

## Hints

- Do not forget to run `mvn test` to generate the test targets if they were changed or extended. The IDE does not cover this behavior.
- All Maven commands can be executed on specific subproject if all dependent subprojects can be found in the local Maven repository. Thus, if you want to avoid rebuilding Soot each time when only wanting to test a specific submodule, execute `mvn clean install` in the root directory and execute further Maven commands in the submodules directory. Remember to reinstall Soot if source code changes.

## Pointers
