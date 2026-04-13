package net.tier1234.deco_lib.api.fluid.util;


public class FluidInteractionUtil {

   /* public static Fluid getFluidFromItemStack(ItemStack stack) {
        if (stack.isEmpty()) {
            return Fluids.EMPTY;
        }

        // Use FluidUtil to get the fluid handler
        IFluidHandlerItem handler = FluidUtil.getFluidHandler(stack).orElse(null);

        if (handler != null) {
            // Check the fluid in the first tank
            FluidStack fluidInHandler = handler.getFluidInTank(0);
            if (!fluidInHandler.isEmpty()) {
                return fluidInHandler.getFluid();
            }
        }

        return Fluids.EMPTY;
    }*/
}