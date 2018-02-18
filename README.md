English / [Magyar](https://github.com/NorbiPeti/OneCommandHelper/blob/master/README_hu.md)

# OneCommandHelper
A plugin that allows one (or multiple) command creations to work on Spigot/Bukkit.
This is needed because the plugins installed on the server may have a command which replaces a vanilla command, and the plugin's version may not work the same way.

Let's take /kill as an example.
Essentials has a /kill command, so if you use that plugin, it takes over, so every time you run /kill, it runs that one.
However, that command doesn't know about selectors, so something like `/kill @a[r=1]` wouldn't work with it.

But, there is a syntax in Bukkit, `/plugin:command`, which allows running a specific plugin's command - or Minecraft's.
So simply running `/minecraft:kill` deals with the issue.

But this isn't typically done in one command creations, it'd greatly limit the command length anyways.
So, this plugin does it.

## Installation
Put the downloaded ([see Releases at top or click here](https://github.com/NorbiPeti/OneCommandHelper/releases)) JAR file into the server's plugin directory. No configuration needed.

## Usage
Paste the command into a command block, but *do not power it*. Instead, look at it, and run /occ in the chat.

In case of multiple commands, look at the one the command's creator said to activate.

## Video
[![Video](http://img.youtube.com/vi/rfPeuj0NWVg/0.jpg)](http://www.youtube.com/watch?v=rfPeuj0NWVg)
