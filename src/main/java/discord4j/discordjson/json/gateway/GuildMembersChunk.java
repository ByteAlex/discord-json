package discord4j.discordjson.json.gateway;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import discord4j.discordjson.json.MemberData;
import discord4j.discordjson.possible.Possible;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableGuildMembersChunk.class)
@JsonDeserialize(as = ImmutableGuildMembersChunk.class)
public interface GuildMembersChunk extends Dispatch {

    static ImmutableGuildMembersChunk.Builder builder() {
        return ImmutableGuildMembersChunk.builder();
    }

    @JsonProperty("guild_id")
    String guildId();
    List<MemberData> members();
    @JsonProperty("not_found")
    Possible<List<String>> notFound();
    Possible<PresenceUpdate> presences();

}
