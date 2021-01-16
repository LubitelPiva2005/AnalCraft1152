// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelmish extends EntityModel<Entity> {
	private final ModelRenderer leftleg2;
	private final ModelRenderer righthand;
	private final ModelRenderer lefthand;
	private final ModelRenderer rightleg2;
	private final ModelRenderer head2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer body2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public Modelmish() {
		textureWidth = 64;
		textureHeight = 64;

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(3.0F, 21.0F, 5.0F);
		leftleg2.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		leftleg2.setTextureOffset(0, 60).addBox(0.0F, 2.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		righthand = new ModelRenderer(this);
		righthand.setRotationPoint(-2.0F, 21.0F, -2.0F);
		righthand.setTextureOffset(58, 61).addBox(-1.0F, 2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		righthand.setTextureOffset(58, 0).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		lefthand = new ModelRenderer(this);
		lefthand.setRotationPoint(2.0F, 21.0F, -2.0F);
		lefthand.setTextureOffset(58, 61).addBox(0.0F, 2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		lefthand.setTextureOffset(58, 0).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-3.0F, 21.0F, 5.0F);
		rightleg2.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		rightleg2.setTextureOffset(0, 60).addBox(-1.0F, 2.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, 19.0F, -4.0F);
		setRotationAngle(head2, 0.2618F, 0.0F, 0.0F);
		head2.setTextureOffset(23, 57).addBox(-1.5F, -1.1022F, -3.7765F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		head2.setTextureOffset(25, 52).addBox(-1.5F, -0.1022F, -5.7765F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		head2.setTextureOffset(60, 30).addBox(-0.5F, -0.1022F, -6.7765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(28, 32).addBox(1.0F, -0.6022F, -2.7765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(28, 32).addBox(-2.0F, -0.6022F, -2.7765F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(-3.0F, -1.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(-3.0F, 0.8978F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(-2.0F, -0.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(2.0F, 0.8978F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(2.0F, -1.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(1.0F, -0.1022F, -4.7765F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.0F, -0.1022F, 2.2235F);
		head2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.2182F, 0.0F);
		cube_r1.setTextureOffset(34, 39).addBox(-1.5F, -3.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-1.0F, -0.1022F, 2.2235F);
		head2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.2182F, 0.0F);
		cube_r2.setTextureOffset(34, 37).addBox(-1.5F, -3.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(0.0F, 20.0F, 1.0F);
		body2.setTextureOffset(20, 0).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
		body2.setTextureOffset(25, 11).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.0F, -2.0F, 4.0F);
		body2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0436F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(54, 41).addBox(-1.5F, 4.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -5.0F, 3.0F);
		body2.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.3927F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(54, 41).addBox(-0.7F, 3.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r4.setTextureOffset(54, 35).addBox(-1.0F, 3.0F, 3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leftleg2.render(matrixStack, buffer, packedLight, packedOverlay);
		righthand.render(matrixStack, buffer, packedLight, packedOverlay);
		lefthand.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg2.render(matrixStack, buffer, packedLight, packedOverlay);
		head2.render(matrixStack, buffer, packedLight, packedOverlay);
		body2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.lefthand.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.righthand.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head2.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head2.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}