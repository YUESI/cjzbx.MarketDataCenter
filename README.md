# cjzbx.MarketDataCenter

关联远程库
git remote add origin git@github.com:YUESI/cjzbx.MarketDataCenter.git
git pull origin master

彻底删除文件
git filter-branch --index-filter 'git rm -r --cached --ignore-unmatch .gitinore src/main/resources/config/' HEAD
git push origin master --force
rm -rf .git/refs/original/
git reflog expire --expire=now --all
git gc --prune=now
git gc --aggressive --prune=now

http://localhost:18081/swagger-ui.html