package com.permadeathcore.f;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

class f {
   private Block b;
   // $FF: synthetic field
   final e a;

   public f(e var1, Block var2) {
      this.a = var1;
      this.b = var2;
   }

   public f a() {
      this.b = this.b.getRelative(BlockFace.DOWN);
      return this;
   }

   public Block b() {
      return this.b;
   }
}
