package com.permadeathcore.j;

import java.util.logging.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.Filter.Result;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

public class b extends AbstractFilter {
   private static final long a = -5594073755007974254L;

   private static Result a(Message var0) {
      return var0 == null ? Result.NEUTRAL : a(var0.getFormattedMessage());
   }

   private static Result a(String var0) {
      if (var0.contains("Ignoring unknown attribute")) {
         return Result.DENY;
      } else {
         return var0.contains("Summoned new Wither") ? Result.DENY : Result.NEUTRAL;
      }
   }

   public Result filter(LogEvent var1) {
      Message var2 = null;
      if (var1 != null) {
         var2 = var1.getMessage();
      }

      return a(var2);
   }

   public Result a(Logger var1, Level var2, Marker var3, Message var4, Throwable var5) {
      return a(var4);
   }

   public Result a(Logger var1, Level var2, Marker var3, String var4, Object... var5) {
      return a(var4);
   }

   public Result a(Logger var1, Level var2, Marker var3, Object var4, Throwable var5) {
      String var6 = null;
      if (var4 != null) {
         var6 = var4.toString();
      }

      return a(var6);
   }
}
