<div align="center">

# MobSkullLib

###### • [Wiki][2] • [Issue Tracker][3] • [Discord Guild][4] •

MobSkullLib is a multi-platform resource for plugin development, providing an easy way to
retrieve a player skull with the texture of a given entity type. It utilises textures retrieved
from the [Minecraft Heads](https://minecraft-heads.com/) website.

> **Warning:** MobSkullLib is currently not released, as it does not have a skull texture mapped for
> all of the required entity types. Please consider contributing to the project by submitting a
> PR with more of the textures set. :)

</div>

***

## 👉 Features

- [x] Built for multi-platform support.
- [x] Can be shaded inside your plugins, and can be depended upon externally as a separate plugin. 
- [ ] Well-documented.
  - ...not just yet. ;) 
- [x] Uses unit tests to avoid buggy releases.
- [x] As light as a feather.. as it should be!

## 🛠️ Platforms

### PaperMC

> Requires Java 17 and MC 1.18+

MobSkullLib has a PaperMC-API implementation, `MobSkullLib-PaperMC`. It can be shaded into
(recommended), or depended upon as an external plugin, to integrate with your PaperMC plugins.

### Sponge and Minestom

Planned, although currently unavailable. Please let me know if you're interested in using either
of these implementations.

### Bukkit, BungeeCord, Velocity

There are no current plans to provide an implementation for any of these platforms, however,
contributions are warmly welcome. Specifically, a Bukkit implementation has been omitted as it
seems to require NMS usage.

## 📜 License

> MobSkullLib may not be used in proprietary software. Please view,
> '[Why open source my premium plugin?][1]'.

<details>
<summary>Click to toggle license notice.</summary>

Copyright (C) 2022 lokka30 and MobSkullLib contributors

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

</details>


[1]: https://www.spigotmc.org/wiki/list-of-open-source-premium-plugins/
[2]: https://www.github.com/ArcanePlugins/MobSkullLib/wiki/
[3]: https://www.github.com/ArcanePlugins/MobSkullLib/issues/
[4]: https://discord.gg/HqZwdcJ