require 'rubygems'
require 'railsless-deploy'

set :application, "emperor"

set :scm, :none
set :repository,  "target/universal"
set :deploy_via, :copy

role :web, "beta.emperorapp.com"

# ssh_options[:keys] = [File.join(ENV["HOME"], "corykey.pem")]

set :deploy_to, "/home/emperor"
set :user, "emperor"
set :use_sudo, false
set :copy_exclude, ["stage", "tmp"]

after "deploy:update", "deploy:doprep"
after "deploy:restart", "deploy:cleanup"

namespace :deploy do
  task :doprep do
    run "cd current; unzip *.zip"
    run ""
  end
  task :start do
    run "cd current/emperor-*; nohup bin/emperor -mem 512 -J-Dconfig.file=/home/emperor/production.conf -J-Dpidfile.path=/home/emperor/emperor.pid >/dev/null 2>&1 &"
  end
  task :stop do
    run "kill -15 `cat /home/emperor/emperor.pid`"
  end
end
