// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelkrisarrrsdf extends EntityModel<Entity> {
	private final ModelRenderer leftleg2;
	private final ModelRenderer righthand;
	private final ModelRenderer lefthand;
	private final ModelRenderer rightleg2;
	private final ModelRenderer head2;
	private final ModelRenderer body2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public Modelkrisarrrsdf() {
		textureWidth = 16;
		textureHeight = 16;

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(5.0F, 22.0F, 5.0F);
		leftleg2.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		leftleg2.setTextureOffset(0, 0).addBox(-2.0F, 1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		righthand = new ModelRenderer(this);
		righthand.setRotationPoint(0.0F, 22.0F, -3.0F);
		righthand.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		righthand.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		lefthand = new ModelRenderer(this);
		lefthand.setRotationPoint(5.0F, 22.0F, -3.0F);
		lefthand.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		lefthand.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-2.0F, 22.0F, 5.0F);
		rightleg2.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		rightleg2.setTextureOffset(0, 0).addBox(-2.0F, 1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(-2.0F, 22.0F, -4.0F);
		setRotationAngle(head2, 0.2618F, 0.0F, 0.0F);
		head2.setTextureOffset(0, 0).addBox(0.5F, -4.0F, -3.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(0.5F, -3.0F, -5.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(1.5F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(-0.5F, -6.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(2.5F, -6.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(3.0F, -3.5F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(0, 0).addBox(0.0F, -3.5F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(-2.0F, 22.0F, -1.0F);
		body2.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 1.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
		body2.setTextureOffset(0, 0).addBox(0.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.0F, -7.0F, 5.0F);
		body2.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 4).addBox(-0.7F, 3.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 3).addBox(-1.0F, 3.0F, 3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(4.0F, -4.0F, 6.0F);
		body2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.3927F, 0.0F);
		cube_r2.setTextureOffset(0, 4).addBox(0.2F, 4.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(4.0F, -4.0F, 11.0F);
		body2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(0, 4).addBox(0.7F, 5.0F, 5.0F, 0.0F, 0.0F, 4.0F, 0.0F, false);
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
		this.lefthand.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.rightleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.righthand.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head2.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head2.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}