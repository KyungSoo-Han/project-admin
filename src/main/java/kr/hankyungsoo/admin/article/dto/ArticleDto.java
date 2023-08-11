package kr.hankyungsoo.admin.article.dto;

import kr.hankyungsoo.admin.user.dto.UserAccountDto;
import java.time.LocalDateTime;
import java.util.Set;

public record ArticleDto(
        Long id,
        UserAccountDto userAccount,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ArticleDto of(Long id, UserAccountDto userAccount, String title, String content, String hashtags, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleDto(id, userAccount, title, content, hashtags, createdAt, createdBy, modifiedAt, modifiedBy);
    }

}