package dev.javacity.core.models;

import java.util.Collection;
import java.util.List;

public class PackageRepository implements Repository<DefaultEntityIdentifier, TargetPackage> {

	private List<TargetPackage> entities;
	private int lastId;

	@Override
	public Collection<TargetPackage> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public TargetPackage findById(DefaultEntityIdentifier identifier) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void store(TargetPackage entity) {
		this.entities.add(entity);
	}

	@Override
	public EntityIdentifier nextIndentifier() {
		return new DefaultEntityIdentifier(++this.lastId);
	}

	@Override
	public List<EntityIdentifier> getAllTrackingIds() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
