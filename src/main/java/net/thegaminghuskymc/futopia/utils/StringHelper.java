package net.thegaminghuskymc.futopia.utils;

import java.util.List;
import java.util.Locale;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.input.Keyboard;

public final class StringHelper
{
    /*private static final class Numeral extends Enum
    {

        public static Numeral[] values()
        {
            return (Numeral[])$VALUES.clone();
        }

        public static Numeral valueOf(String name)
        {
            return (Numeral)Enum.valueOf(StringHelper.class, name);
        }

        public static final Numeral M;
        public static final Numeral CM;
        public static final Numeral D;
        public static final Numeral CD;
        public static final Numeral C;
        public static final Numeral XC;
        public static final Numeral L;
        public static final Numeral XL;
        public static final Numeral X;
        public static final Numeral IX;
        public static final Numeral V;
        public static final Numeral IV;
        public static final Numeral I;
        public final String name = name();
        public final int value;
        private static final Numeral values[] = values();
        private static final Numeral $VALUES[];

        static 
        {
            M = new Numeral("M", 0, 1000);
            CM = new Numeral("CM", 1, 900);
            D = new Numeral("D", 2, 500);
            CD = new Numeral("CD", 3, 400);
            C = new Numeral("C", 4, 100);
            XC = new Numeral("XC", 5, 90);
            L = new Numeral("L", 6, 50);
            XL = new Numeral("XL", 7, 40);
            X = new Numeral("X", 8, 10);
            IX = new Numeral("IX", 9, 9);
            V = new Numeral("V", 10, 5);
            IV = new Numeral("IV", 11, 4);
            I = new Numeral("I", 12, 1);
            $VALUES = (new Numeral[] {
                M, CM, D, CD, C, XC, L, XL, X, IX, 
                V, IV, I
            });
        }


        private Numeral(String s, int i, int val)
        {
            super();
            value = val;
        }
    }*/


    private StringHelper()
    {
    }

    public static String toString(Object o, String nullDefault)
    {
        return o == null ? nullDefault : o.toString();
    }

    public static boolean isAltKeyDown()
    {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }

    public static boolean isControlKeyDown()
    {
        return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }

    public static boolean isShiftKeyDown()
    {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    public static int getSplitStringHeight(FontRenderer fontRenderer, String input, int width)
    {
        List stringRows = fontRenderer.listFormattedStringToWidth(input, width);
        return stringRows.size() * fontRenderer.FONT_HEIGHT;
    }

    public static String titleCase(String input)
    {
        return (new StringBuilder()).append(input.substring(0, 1).toUpperCase(Locale.US)).append(input.substring(1)).toString();
    }

    public static String localize(String key)
    {
        return I18n.translateToLocal(key);
    }

    public static String localizeFormat(String key, Object format[])
    {
        return I18n.translateToLocalFormatted(key, format);
    }

    public static boolean canLocalize(String key)
    {
        return I18n.canTranslate(key);
    }

    public static String getKeyName(int key)
    {
        return key >= 0 ? Keyboard.getKeyName(key) : I18n.translateToLocalFormatted("key.mouseButton", new Object[] {
            Integer.valueOf(key + 101)
        });
    }

    public static String getFluidName(FluidStack stack)
    {
        Fluid fluid = stack.getFluid();
        String name = "\247r";
        if(fluid.getRarity() == EnumRarity.UNCOMMON)
            name = (new StringBuilder()).append(name).append("\247e").toString();
        else
        if(fluid.getRarity() == EnumRarity.RARE)
            name = (new StringBuilder()).append(name).append("\247b").toString();
        else
        if(fluid.getRarity() == EnumRarity.EPIC)
            name = (new StringBuilder()).append(name).append("\247d").toString();
        name = (new StringBuilder()).append(name).append(fluid.getLocalizedName(stack)).append("\247r").toString();
        return name;
    }

    public static String getFluidName(FluidStack stack, String defaultName)
    {
        if(stack == null)
            return defaultName;
        else
            return getFluidName(stack);
    }

    public static String getItemName(ItemStack stack)
    {
        String name = "\247r";
        if(stack.getRarity() == EnumRarity.UNCOMMON)
            name = (new StringBuilder()).append(name).append("\247e").toString();
        else
        if(stack.getRarity() == EnumRarity.RARE)
            name = (new StringBuilder()).append(name).append("\247b").toString();
        else
        if(stack.getRarity() == EnumRarity.EPIC)
            name = (new StringBuilder()).append(name).append("\247d").toString();
        name = (new StringBuilder()).append(name).append(stack.getDisplayName()).append("\247r").toString();
        return name;
    }

    public static String getScaledNumber(long number)
    {
        if(number >= 0x3b9aca00L)
            return (new StringBuilder()).append(number / 0x3b9aca00L).append(".").append((number % 0x3b9aca00L) / 0x989680L).append("G").toString();
        if(number >= 0xf4240L)
            return (new StringBuilder()).append(number / 0xf4240L).append(".").append((number % 0xf4240L) / 10000L).append("M").toString();
        if(number >= 1000L)
            return (new StringBuilder()).append(number / 1000L).append(".").append((number % 1000L) / 10L).append("k").toString();
        else
            return String.valueOf(number);
    }

    /*public static String toNumerals(short v)
    {
        String s = (new StringBuilder()).append("potion.potency.").append(v).toString();
        if(I18n.canTranslate(s))
            return I18n.translateToLocalFormatted(s, new Object[0]);
        StringBuilder r = new StringBuilder();
        int i = v;
        if(i < 0)
        {
            i = -i;
            r.append('-');
        }
        Numeral anumeral[] = Numeral.values;
        int l = anumeral.length;
        for(int i1 = 0; i1 < l; i1++)
        {
            Numeral k = anumeral[i1];
            for(int j = i / k.value; j-- > 0;)
                r.append(k.name);

            i %= k.value;
        }

        return r.toString();
    }*/

    /**
     * @deprecated Method getScaledNumber is deprecated
     */

    public static String getScaledNumber(long number, int minDigits)
    {
        return getScaledNumber(number);
    }

    public static String getActivationText(String key)
    {
        return (new StringBuilder()).append("\247b").append(localize(key)).append("\247r").toString();
    }

    public static String getDeactivationText(String key)
    {
        return (new StringBuilder()).append("\247e").append(localize(key)).append("\247r").toString();
    }

    public static String getInfoText(String key)
    {
        return (new StringBuilder()).append("\247a").append(localize(key)).append("\247r").toString();
    }

    public static String getNoticeText(String key)
    {
        return (new StringBuilder()).append("\2476").append(localize(key)).append("\247r").toString();
    }

    public static String getFlavorText(String key)
    {
        return (new StringBuilder()).append("\2477").append(localize(key)).append("\247r").toString();
    }

    public static String getRarity(int level)
    {
        switch(level)
        {
        case 2: // '\002'
            return "\247e";

        case 3: // '\003'
            return "\247b";
        }
        return "\2477";
    }

    public static String shiftForDetails()
    {
        return localize("info.futopia.holdShiftForDetails");
    }

    public static String tutorialTabAugment()
    {
        return localize("info.futopia.tutorial.tabAugment");
    }

    public static String tutorialTabAugmentUpgrade()
    {
        return localize("info.futopia.tutorial.tabAugmentUpgrade");
    }

    public static String tutorialTabConfiguration()
    {
        return localize("info.futopia.tutorial.tabConfiguration");
    }

    public static String tutorialTabRedstone()
    {
        return localize("info.futopia.tutorial.tabRedstone");
    }

    public static String tutorialTabSecurity()
    {
        return localize("info.futopia.tutorial.tabSecurity");
    }

    public static String tutorialTabFluxRequired()
    {
        return localize("info.futopia.tutorial.fluxRequired");
    }

    public static final String ROMAN_NUMERAL[] = {
        "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", 
        "X"
    };
    public static final String BLACK = "\2470";
    public static final String BLUE = "\2471";
    public static final String GREEN = "\2472";
    public static final String TEAL = "\2473";
    public static final String RED = "\2474";
    public static final String PURPLE = "\2475";
    public static final String ORANGE = "\2476";
    public static final String LIGHT_GRAY = "\2477";
    public static final String GRAY = "\2478";
    public static final String LIGHT_BLUE = "\2479";
    public static final String BRIGHT_GREEN = "\247a";
    public static final String BRIGHT_BLUE = "\247b";
    public static final String LIGHT_RED = "\247c";
    public static final String PINK = "\247d";
    public static final String YELLOW = "\247e";
    public static final String WHITE = "\247f";
    public static final String OBFUSCATED = "\247k";
    public static final String BOLD = "\247l";
    public static final String STRIKETHROUGH = "\247m";
    public static final String UNDERLINE = "\247n";
    public static final String ITALIC = "\247o";
    public static final String END = "\247r";
    public static boolean displayShiftForDetail = true;
    public static boolean displayStackCount = false;

}
