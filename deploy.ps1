# Zielordner sicherstellen
New-Item -ItemType Directory -Force -Path ./deploy | Out-Null

# Alle .jar-Dateien in target-Ordnern finden und verschieben
Get-ChildItem -Recurse -Filter *.jar |
        Where-Object { $_.FullName -match '[\\/]target[\\/]' } |
        ForEach-Object {
            Move-Item -Path $_.FullName -Destination ./deploy/ -Force
        }
