# CoinWhisper

## 1. Cloning & branching
1) Clone the repo using git/terminal.
   ```
   git clone https://github.com/Rohit-MyRG/CoinWhisper.git
   ```
   ```
   cd CoinWhisper
   ```
2) Check existing branches.
   ```
   git branch -a
   ```

3) Create a new sub-branch.</br>
   Always create a new branch for each new function/service and even for new changes.</br>
   For example if you want to create a new branch called **"mysub-branch"** under the branch named **"dev"** follow the steps:</br>
   i) Checkout or change into **"dev"**
   ```
   git checkout dev
   ```
   ii) Now create your new branch called **"mysub-branch"** under the **"dev"** using the following command.</br>
   syntax: ```git checkout -b <new-sub-branch> <base-branch>```
   ```
   git checkout -b mysub-branch dev
   ```
   Now you are ready to add/make changes in the new branch.

4) Commit the changes.</br>
    Please use following git commands to check status and commit your changes.
    ```
    git status
    ```
    ```
    git add .
    ```
    ```
    git commit -m "feat: add new button"
    ```

5) Pull before Push.</br>
   Yes, after you make changes and commit to your new sub-branch, you have to pull from the base branch to avoid conflicts.
   ```
   git pull origin dev
   ```
   This command will pull all new commits from the base branch to the sub-branch.

6) Build before Push.</br>
   Use the below maven command to clean and build your project, or through your IDE.
   ```
   mvn -U clean install
   ```
   
7) Push before Pull Request.</br>
   Push your new changes from the local sub-branch to the remote sub-branch.
   ```
   git push -u origin mysub-branch
   ```

8) Visit the Remote repo and PR your sub-branch to base-branch **"dev"**.
   


## 2. Commit Naming Convention
A commit message should start with a category of change. You can pretty much use the following first 4 categories for everything: **feat, fix, refactor, and chore**.

* **feat**: is for adding a new feature </br>
* **fix**: is for fixing a bug </br>
* **refactor**: is for changing code for peformance or convenience purpose (neither fixes a bug nor adds a feature) </br>
* **chore**: is for everything else (writing documentation, formatting, adding tests, cleaning useless code etc.) </br>

* **build**: Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm) </br>
* **docs**: Documentation only changes </br>
* **perf**: A code change that improves performance </br>
* **ci**: Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs) </br>
* **style**: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc) </br>
* **test**: Adding missing tests or correcting existing tests </br>

### To sum up, follow this pattern when committing:
```
git commit -m '<category: do something; do some other things>'
```

### Examples:
```
git commit -m 'feat: add new button component; add new button components to templates'

git commit -m 'fix: add the stop directive to button component to prevent propagation'

git commit -m 'refactor: rewrite button component in TypeScript'

git commit -m 'chore: write button documentation'
```

</br>

## 3. Branch Naming Convention
A git branch should start with a category. Pick one of these: feature, bugfix, hotfix, or test.
### Category
* **feature** is for adding, refactoring or removing a feature
* **bugfix** is for fixing a bug
* **hotfix** is for changing code with a temporary solution and/or without following the usual process (usually because of an emergency)
* **test** is for experimenting outside of an issue/ticket

### Reference
* After the category, there should be a "/" followed by the reference of the issue/ticket you are working on. If there's no reference, just add no-ref.

### To sum up, follow this pattern when branching:
```
git branch <category/reference>
```
### Examples:

* You need to add, refactor or remove a feature: 
``` 
git branch feature/issue-42 
```
* You need to fix a bug: 
```
git branch bugfix/issue-342
```
* You need to fix a bug really fast (possibly with a temporary solution): 
```
git branch hotfix/no-ref
```
* You need to experiment outside of an issue/ticket: 
``` 
git branch test/no-ref
```




