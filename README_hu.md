[English](https://github.com/NorbiPeti/OneCommandHelper/blob/master/README.md) / Magyar

# OneCommandHelper
Egy plugin, ami működőképessé teszi az egy (vagy több) parancsos alkotásokat Spigot/Bukkit szervereken.
Erre azért van szükség, mert a szerverekre telepített pluginoknak lehet olyan parancsuk, ami lecserél egy beépített parancsot.

Vegyül például a /kill parancsot.
Az Essentialsnak van /kill parancsa, ezért ha használod azt a plugint, minden alkalommal, amikor lefuttatod a /kill prancsot, azt futtatja le.
Ugyanakkor az a parancs nem ismeri a szelektorokat, ezért pl. a `/kill @a[r=1]` parancs nem működne vele.

De van egy szintaxis a Bukkitban, `/plugin:parancs`, ami lehetővé teszi egy bizonyos plugin - vagy a Minecraft - parancsának a futtatását.
Így egyszerűen a `/minecraft:kill` futtatása megoldja a problémát.

De ezt általában nem teszik meg az egy parancsos alkotásookban, nagy mértékben korlátozná a parancs hosszúságát egyébként is.
Úgyhogy ez a plugin megcsinálja.

## Telepítés
Rakd a letöltött ([lásd Releases felül vagy kattints ide](https://github.com/NorbiPeti/OneCommandHelper/releases)) JAR fájlt a szerver plugins mappába. Konfiguráció nem szükséges.

## Használat
Illeszd be a parancsot egy parancsblokkba, de *ne aktiváld*, helyette nézz rá a parancsblokkra és írd be a /occ parancsot.

Több parancs esetében arra nézz, amelyiket aktiválni kell a parancs készítője szerint.

## Videó
[![Video](http://img.youtube.com/vi/rfPeuj0NWVg/0.jpg)](http://www.youtube.com/watch?v=rfPeuj0NWVg)
