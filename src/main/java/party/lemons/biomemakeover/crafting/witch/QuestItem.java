package party.lemons.biomemakeover.crafting.witch;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

import java.util.Objects;
import java.util.Random;

public class QuestItem
{
	public static QuestItem of(ItemConvertible item, float points, int maxSize)
	{
		return new QuestItem(item, points, maxSize);
	}

	private final ItemConvertible item;
	private final float points;
	private final int maxSize;

	private QuestItem(ItemConvertible item, float points, int maxSize)
	{
		this.points = points;
		this.item = item;
		this.maxSize = maxSize;
	}

	public float getPoints()
	{
		return points;
	}

	public ItemStack createStack(Random random)
	{
		return new ItemStack(item, maxSize == 1 ? 1 : 1 + random.nextInt(maxSize - 1));
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		QuestItem questItem = (QuestItem) o;
		return Objects.equals(item, questItem.item);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(item, points, maxSize);
	}
}