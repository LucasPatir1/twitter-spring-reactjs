package com.gmail.merikbest2015;

import com.gmail.merikbest2015.dto.request.UserToListsRequest;
import com.gmail.merikbest2015.dto.response.user.CommonUserResponse;
import com.gmail.merikbest2015.model.Lists;
import com.gmail.merikbest2015.repository.projection.*;
import com.gmail.merikbest2015.util.TestConstants;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListsServiceTestHelper {

    private static final ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    public static List<ListProjection> createMockListProjectionList() {
        ListProjection list1 = factory.createProjection(
                ListProjection.class,
                Map.of(
                        "id", 1L,
                        "name", TestConstants.LIST_NAME,
                        "description", TestConstants.LIST_DESCRIPTION,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "listOwnerId", TestConstants.LIST_USER_ID,
                        "listOwner", new CommonUserResponse(),
                        "isFollower", false,
                        "isListPinned", false));
        ListProjection list2 = factory.createProjection(
                ListProjection.class,
                Map.of(
                        "id", 2L,
                        "name", TestConstants.LIST_NAME_2,
                        "description", TestConstants.LIST_DESCRIPTION,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "listOwnerId", TestConstants.LIST_USER_ID,
                        "listOwner", new CommonUserResponse(),
                        "isFollower", false,
                        "isListPinned", false));
        return Arrays.asList(list1, list2);
    }

    public static List<ListUserProjection> createMockListUserProjectionList() {
        ListUserProjection listUser1 = factory.createProjection(
                ListUserProjection.class,
                Map.of(
                        "id", 1L,
                        "name", TestConstants.LIST_NAME,
                        "description", TestConstants.LIST_DESCRIPTION,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "listOwnerId", TestConstants.LIST_USER_ID,
                        "listOwner", new CommonUserResponse(),
                        "isListPinned", false,
                        "isPrivate", false));
        ListUserProjection listUser2 = factory.createProjection(
                ListUserProjection.class,
                Map.of(
                        "id", 2L,
                        "name", TestConstants.LIST_NAME_2,
                        "description", TestConstants.LIST_DESCRIPTION,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "listOwnerId", TestConstants.LIST_USER_ID,
                        "listOwner", new CommonUserResponse(),
                        "isListPinned", false,
                        "isPrivate", false));
        return Arrays.asList(listUser1, listUser2);
    }

    public static List<PinnedListProjection> createMockPinnedListProjectionList() {
        PinnedListProjection pinnedList1 = factory.createProjection(
                PinnedListProjection.class,
                Map.of(
                        "id", 1L,
                        "name", TestConstants.LIST_NAME,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "isListPinned", false,
                        "isPrivate", false));
        PinnedListProjection pinnedList2 = factory.createProjection(
                PinnedListProjection.class,
                Map.of(
                        "id", 2L,
                        "name", TestConstants.LIST_NAME_2,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "isListPinned", false,
                        "isPrivate", false));
        return Arrays.asList(pinnedList1, pinnedList2);
    }

    public static List<SimpleListProjection> createMockSimpleListProjectionList() {
        SimpleListProjection pinnedList1 = factory.createProjection(
                SimpleListProjection.class,
                Map.of(
                        "id", 1L,
                        "name", TestConstants.LIST_NAME,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "isPrivate", false));
        SimpleListProjection pinnedList2 = factory.createProjection(
                SimpleListProjection.class,
                Map.of(
                        "id", 2L,
                        "name", TestConstants.LIST_NAME_2,
                        "altWallpaper", TestConstants.LIST_ALT_WALLPAPER,
                        "wallpaper", "",
                        "isPrivate", false));
        return Arrays.asList(pinnedList1, pinnedList2);
    }

    public static BaseListProjection createMockBaseListProjection(Long listOwnerId) {
        Map<String, Object> baseListMap = new HashMap<>();
        baseListMap.put("id", 1L);
        baseListMap.put("name", TestConstants.LIST_NAME);
        baseListMap.put("description", TestConstants.LIST_DESCRIPTION);
        baseListMap.put("altWallpaper", TestConstants.LIST_ALT_WALLPAPER);
        baseListMap.put("wallpaper", "");
        baseListMap.put("listOwnerId", listOwnerId);
        baseListMap.put("isPrivate", false);
        baseListMap.put("listOwner", new CommonUserResponse());
        baseListMap.put("membersSize", 111L);
        baseListMap.put("followersSize", 111L);
        baseListMap.put("isFollower", true);
        return factory.createProjection(BaseListProjection.class, baseListMap);
    }

    public static Lists createMockLists() {
        Lists lists = new Lists();
        lists.setId(1L);
        lists.setName(TestConstants.LIST_NAME);
        lists.setDescription(TestConstants.LIST_DESCRIPTION);
        lists.setAltWallpaper(TestConstants.LIST_ALT_WALLPAPER);
        lists.setWallpaper("");
        lists.setListOwnerId(TestConstants.LIST_USER_ID);
        return lists;
    }

    public static UserToListsRequest mockUserToListsRequest() {
        UserToListsRequest listsRequest = new UserToListsRequest();
        listsRequest.setUserId(1L);
        listsRequest.setLists(List.of(
                new UserToListsRequest.ListsRequest(1L, true),
                new UserToListsRequest.ListsRequest(2L, false)
        ));
        return listsRequest;
    }
}
