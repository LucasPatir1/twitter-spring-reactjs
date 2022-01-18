import React, {FC, ReactElement} from 'react';
import {Link} from "react-router-dom";
import {Checkbox, Divider, Link as MuiLink, Typography} from "@material-ui/core";

import {useDiscoverabilityStyles} from "./DiscoverabilityStyles";
import {ArrowRightIcon} from "../../../../icons";

const Discoverability: FC = (): ReactElement => {
    const classes = useDiscoverabilityStyles();

    return (
        <>
            <div className={classes.infoItemWrapper}>
                <Typography variant={"subtitle2"} component={"div"}>
                    Control your discoverability settings and manage contacts you’ve imported.
                </Typography>
            </div>
            <div className={classes.infoItemWrapper}>
                <Typography variant={"h5"} component={"div"}>
                    Discoverability
                </Typography>
            </div>
            <div className={classes.infoItemWrapper}>
                <Typography variant={"subtitle2"} component={"div"}>
                    Decide whether people who have your email address or phone number can find and connect with you on
                    Twitter.
                </Typography>
            </div>
            <div className={classes.infoItemWrapper}>
                <div className={classes.infoItem}>
                    <Typography variant={"body1"} component={"span"}>
                        Let people who have your email address find you on Twitter
                    </Typography>
                    <Checkbox/>
                </div>
                <Typography variant={"subtitle2"} component={"div"}>
                    {"Let people who have your email address find and connect with you on Twitter. "}
                    <MuiLink
                        href="https://help.twitter.com/safety-and-security/email-and-phone-discoverability-settings"
                        variant="subtitle2"
                        target="_blank"
                        rel="noopener"
                    >
                        Learn more
                    </MuiLink>
                </Typography>
            </div>
            <div className={classes.infoItemWrapper}>
                <div className={classes.infoItem}>
                    <Typography variant={"body1"} component={"span"}>
                        Let people who have your phone number find you on Twitter
                    </Typography>
                    <Checkbox/>
                </div>
                <Typography variant={"subtitle2"} component={"div"}>
                    {"Let people who have your phone number find and connect with you on Twitter. "}
                    <MuiLink
                        href="https://help.twitter.com/safety-and-security/email-and-phone-discoverability-settings"
                        variant="subtitle2"
                        target="_blank"
                        rel="noopener"
                    >
                        Learn more
                    </MuiLink>
                </Typography>
            </div>
            <Divider/>
            <div className={classes.infoItemWrapper}>
                <Typography variant={"h5"} component={"div"}>
                    Contacts
                </Typography>
            </div>
            <div className={classes.infoItemWrapper}>
                <Typography variant={"subtitle2"} component={"div"}>
                    {"Manage contacts that you have imported from your mobile devices. "}
                    <MuiLink
                        href="https://help.twitter.com/using-twitter/upload-your-contacts-to-search-for-friends"
                        variant="subtitle2"
                        target="_blank"
                        rel="noopener"
                    >
                        Learn more
                    </MuiLink>
                </Typography>
            </div>
            <Link to={"/settings/privacy_and_safety/contacts_dashboard"} className={classes.discoverabilityWrapper}>
                <div className={classes.discoverabilityLink}>
                    <Typography variant={"body1"} component={"span"}>
                        Manage contacts
                    </Typography>
                    {ArrowRightIcon}
                </div>
            </Link>
        </>
    );
};

export default Discoverability;
