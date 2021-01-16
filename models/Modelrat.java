// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelrat extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer head;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer bone;

	public Modelrat() {
		textureWidth = 16;
		textureHeight = 16;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, -1.0F);
		body.setTextureOffset(0, 6).addBox(-3.0F, 1.0F, 1.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 4).addBox(-2.5F, 1.5F, -3.5F, 5.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -1.0F, 5.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 3).addBox(-1.0F, 3.0F, 3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 4).addBox(-0.7F, 3.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(2.0F, 2.0F, 6.0F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.3927F, 0.0F);
		cube_r2.setTextureOffset(0, 4).addBox(0.2F, 4.5F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(2.0F, 2.0F, 11.0F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(0, 4).addBox(0.7F, 5.0F, 5.0F, 0.0F, 0.0F, 4.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(0.0F, 16.0F, -1.0F);
		leftLeg.setTextureOffset(0, 3).addBox(3.0F, 4.0F, 5.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 3).addBox(3.3F, 7.0F, 4.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(0.0F, 16.0F, -1.0F);
		rightLeg.setTextureOffset(0, 3).addBox(-4.5F, 4.0F, 5.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 3).addBox(-4.3F, 7.0F, 4.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(0.0F, 16.0F, -1.0F);
		leftArm.setTextureOffset(0, 2).addBox(2.5F, 5.0F, -2.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		leftArm.setTextureOffset(0, 2).addBox(2.55F, 7.0F, -3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(0.0F, 16.0F, -1.0F);
		rightArm.setTextureOffset(0, 2).addBox(-3.5F, 5.0F, -2.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(0, 2).addBox(-3.35F, 7.0F, -3.5F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 16.0F, -1.0F);
		head.setTextureOffset(0, 1).addBox(-0.3F, 5.5F, -9.7F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-5.0F, 0.0F, 0.0F);
		head.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3927F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(0, 1).addBox(2.5F, 1.0F, -7.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r4.setTextureOffset(0, 1).addBox(7.0F, 1.0F, -7.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r4.setTextureOffset(0, 0).addBox(2.0F, -1.5F, -4.5F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r4.setTextureOffset(0, 0).addBox(6.0F, -1.5F, -4.5F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -2.0F, -5.0F);
		head.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3927F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 2).addBox(-1.5F, 5.0F, -6.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, -2.0F);
		head.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.3927F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(0, 4).addBox(-2.0F, 1.0F, -6.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(8.0F, 24.0F, -9.0F);

	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}