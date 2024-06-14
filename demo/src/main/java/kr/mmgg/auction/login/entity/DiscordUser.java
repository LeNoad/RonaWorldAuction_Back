package kr.mmgg.auction.login.entity;

public class DiscordUser {
    private Long id;
    private String username;
    private String discriminator;
    private String global_name;
    private String avatar;
    private Boolean bot;
    private Boolean system;
    private Boolean mfa_enabled;
    private String banner;
    private Integer accent_color;
    private String locale;
    private Boolean verified;
    private String email;
    private Integer flags;
    private Integer premium_type;
    private Integer public_flags;
    private String avatar_decoration;
    
	@Override
	public String toString() {
		return "DiscordUser [id=" + id + ", username=" + username + ", discriminator=" + discriminator
				+ ", global_name=" + global_name + ", avatar=" + avatar + ", bot=" + bot + ", system=" + system
				+ ", mfa_enabled=" + mfa_enabled + ", banner=" + banner + ", accent_color=" + accent_color + ", locale="
				+ locale + ", verified=" + verified + ", email=" + email + ", flags=" + flags + ", premium_type="
				+ premium_type + ", public_flags=" + public_flags + ", avatar_decoration=" + avatar_decoration + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDiscriminator() {
		return discriminator;
	}
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}
	public String getGlobal_name() {
		return global_name;
	}
	public void setGlobal_name(String global_name) {
		this.global_name = global_name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Boolean getBot() {
		return bot;
	}
	public void setBot(Boolean bot) {
		this.bot = bot;
	}
	public Boolean getSystem() {
		return system;
	}
	public void setSystem(Boolean system) {
		this.system = system;
	}
	public Boolean getMfa_enabled() {
		return mfa_enabled;
	}
	public void setMfa_enabled(Boolean mfa_enabled) {
		this.mfa_enabled = mfa_enabled;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public Integer getAccent_color() {
		return accent_color;
	}
	public void setAccent_color(Integer accent_color) {
		this.accent_color = accent_color;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getFlags() {
		return flags;
	}
	public void setFlags(Integer flags) {
		this.flags = flags;
	}
	public Integer getPremium_type() {
		return premium_type;
	}
	public void setPremium_type(Integer premium_type) {
		this.premium_type = premium_type;
	}
	public Integer getPublic_flags() {
		return public_flags;
	}
	public void setPublic_flags(Integer public_flags) {
		this.public_flags = public_flags;
	}
	public String getAvatar_decoration() {
		return avatar_decoration;
	}
	public void setAvatar_decoration(String avatar_decoration) {
		this.avatar_decoration = avatar_decoration;
	}

    // getters and setters
    
}
