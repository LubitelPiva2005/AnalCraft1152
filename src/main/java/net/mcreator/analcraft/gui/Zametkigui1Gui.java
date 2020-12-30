
package net.mcreator.analcraft.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import net.mcreator.analcraft.AnalCraftModElements;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@AnalCraftModElements.ModElement.Tag
public class Zametkigui1Gui extends AnalCraftModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public Zametkigui1Gui(AnalCraftModElements instance) {
		super(instance, 252);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("zametkigui_1"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(0);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}
		private static final ResourceLocation texture = new ResourceLocation("anal_craft:textures/zametkigui_1.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("anal_craft:textures/book.png"));
			this.blit(this.guiLeft + -47, this.guiTop + -11, 0, 0, 271, 180, 271, 180);
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("\u0412 \u0434\u0430\u043D\u043D\u043E\u043C \u0440\u0430\u0437\u0434\u0435\u043B\u0435", -29, 7, -12829636);
			this.font.drawString("\u0431\u0443\u0434\u0435\u0442 \u043F\u043E\u044F\u0432\u043B\u044F\u0442\u044C\u0441\u044F", -29, 16, -12829636);
			this.font.drawString("\u043E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u0433\u043B\u0430\u0432\u043D\u044B\u0445", -29, 25, -12829636);
			this.font.drawString("\u044D\u043B\u0435\u043C\u0435\u043D\u0442\u043E\u0432 \u0438\u0433\u0440\u043E\u0432\u043E\u0433\u043E", -29, 34,
					-12829636);
			this.font.drawString("\u043F\u0440\u043E\u0446\u0435\u0441\u0441\u0430.", -29, 43, -12829636);
			this.font.drawString("\u041D\u0435 \u0432\u0441\u0435 \u0442\u0430\u0439\u043D\u044B \u044D\u0442\u043E\u0433\u043E", -29, 52, -12829636);
			this.font.drawString("\u043F\u0440\u0435\u043A\u0440\u0430\u0441\u043D\u043E\u0433\u043E \u043C\u0438\u0440\u0430", -29, 61, -12829636);
			this.font.drawString("\u0441\u0440\u0430\u0437\u0443 \u043E\u0442\u043A\u0440\u044B\u0442\u044B \u0434\u043B\u044F \u0432\u0430\u0441,",
					-29, 70, -12829636);
			this.font.drawString("\u0447\u0442\u043E\u0431\u044B \u0434\u043E\u0431\u0430\u0432\u0438\u0442\u044C", -29, 79, -12829636);
			this.font.drawString("\u043D\u043E\u0432\u0443\u044E \u0441\u0442\u0440\u0430\u043D\u0438\u0446\u0443", -29, 88, -12829636);
			this.font.drawString("\u043F\u043E\u043B\u043E\u0436\u0438\u0442\u0435 \u0432 \u043A\u0440\u0430\u0444\u0442\u043E\u0432\u043E\u0435",
					-29, 97, -12829636);
			this.font.drawString("\u043E\u043A\u043E\u0448\u043A\u043E \u043A\u043D\u0438\u0433\u0443 \u0441", -29, 106, -12829636);
			this.font.drawString("\u043D\u0430\u0439\u0434\u0435\u043D\u043E\u0439 \u0437\u0430\u043F\u0438\u0441\u044C\u044E.", -29, 115, -12829636);
			this.font.drawString("\u0427\u0430\u0441\u0442\u0438 \u0441\u0442\u0440\u0430\u043D\u0438\u0446 \u043C\u043E\u0436\u043D\u043E", -29, 124,
					-12829636);
			this.font.drawString("\u0431\u0443\u0434\u0435\u0442 \u043D\u0430\u0439\u0442\u0438 \u0443 \u043D\u043F\u0441", -29, 133, -12829636);
			this.font.drawString("\u0438\u043B\u0438 \u0432 \u0441\u0443\u043D\u0434\u0443\u043A\u0430\u0445.", -20, 142, -12829636);
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
