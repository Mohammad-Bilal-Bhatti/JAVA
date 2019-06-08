public interface RubixCubeInterface{
	public void rotateFront(boolean inverse);
	public void rotateBack(boolean inverse);
	public void rotateLeft(boolean inverse);
	public void rotateRight(boolean inverse);
	public void rotateTop(boolean inverse);
	public void rotateDown(boolean inverse);
	public boolean isSolved();
	public void scramble();
	public void scramble(int times);

}
