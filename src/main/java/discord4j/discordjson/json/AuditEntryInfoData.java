package discord4j.discordjson.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import discord4j.discordjson.possible.Possible;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableAuditEntryInfoData.class)
@JsonDeserialize(as = ImmutableAuditEntryInfoData.class)
public interface AuditEntryInfoData {

    static ImmutableAuditEntryInfoData.Builder builder() {
        return ImmutableAuditEntryInfoData.builder();
    }

    @JsonProperty("delete_member_days")
    Possible<String> deleteMemberDays();

    @JsonProperty("members_removed")
    Possible<String> membersRemoved();

    @JsonProperty("channel_id")
    Possible<String> channelId();

    @JsonProperty("message_id")
    Possible<String> messageId();

    Possible<String> count();

    Possible<String> id();

    Possible<String> type();

    @JsonProperty("role_name")
    Possible<String> roleName();
}
