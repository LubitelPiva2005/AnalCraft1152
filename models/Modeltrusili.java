// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeltrusili extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modeltrusili() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(20, 1).addBox(-4.0F, 11.0F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(-4.0F, 11.0F, -3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 20).addBox(4.0F, 11.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 27).addBox(-5.0F, 11.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(0, 13).addBox(0.9F, 2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		RightLeg.setTextureOffset(4, 5).addBox(0.9F, 1.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(20, 3).addBox(-1.1F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 3).addBox(-1.1F, 0.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 5).addBox(0.9F, 1.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(8, 5).addBox(-1.9F, 1.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(8, 3).addBox(-1.9F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(8, 3).addBox(-1.9F, 0.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(8, 5).addBox(-1.9F, 1.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(10, 13).addBox(-1.9F, 2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}