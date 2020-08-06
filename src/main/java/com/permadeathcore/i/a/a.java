package com.permadeathcore.i.a;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockBreakEvent;

public interface a {
   Location a(Block var1, BlockFace var2);

   void a(Location var1);

   void a(BlockBreakEvent var1);

   boolean b(Location var1);
}
