intialize git
git init

git remote add origin "http ..... git"

--If red(workspace) green (stagging) white(GitLocal)
git status 

--Add from workspace to stagging
git add -A

git commit -m "message"

git push -u origin branch1


--check your current branch
git branch -a
--or switch to main branch
git checkout main

--create new branch
git checkout -b branch1

--list of all branches
git branch 

--fetch master to yor local branch
git fetch origin

git merge master