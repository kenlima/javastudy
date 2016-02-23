# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"
boxname = "Dev_Svr"
boxurl = "http://192.168.0.8/box/apache_server.box"
hostname = "wmp-devweb"
vmname = hostname
user_name = "root"
ip_addr = "172.20.0.4"
home_dir = "./www/"
server_dir = "/webroot/"

$script = <<SCRIPT
echo    wemakeprice.com
echo    Local development environment
echo    by jinwoo
echo
echo    -    Done    -
echo
SCRIPT

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = boxname
  config.vm.box_url = boxurl
  config.vm.hostname = hostname
  config.vm.network "private_network", ip: ip_addr
	config.ssh.username = user_name
	config.ssh.forward_agent = true
	config.vm.synced_folder home_dir, server_dir, :create => "true"
	config.vm.synced_folder ".", "/vagrant", disabled:true
  config.vm.provider "virtualbox" do |vb|
    vb.customize ["modifyvm", :id, "--name", vmname]
    vb.customize ["modifyvm", :id, "--memory", "2048"]
    vb.customize ["modifyvm", :id, "--cpus", "2"]
    vb.customize ["modifyvm", :id, "--nic2", "hostonly"]
    vb.customize ["modifyvm", :id, "--audio", "none"]
    vb.customize ["modifyvm", :id, "--boot1", "disk"]
    vb.customize ["modifyvm", :id, "--boot2", "dvd"]
  end
  config.vm.provision "shell", inline: $script
end
