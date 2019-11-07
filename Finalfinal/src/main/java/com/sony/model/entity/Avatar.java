package com.sony.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "avatar")
public class Avatar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "avatar_sequence")
	@SequenceGenerator(name = "avatar_sequence", sequenceName = "AVATAR_ID_SEQ")
	@Column(name = "avatar_id")
	private Integer avatarId;

	@Lob
	@Column(name = "image", columnDefinition = "BLOB")
	private byte[] image;

	public Avatar() {
	}

	public Avatar(byte[] image) {
		this.image = image;
	}

	public Integer getAvatarId() {
		return this.avatarId;
	}

	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
